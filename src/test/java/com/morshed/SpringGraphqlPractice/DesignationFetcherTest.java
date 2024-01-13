package com.morshed.SpringGraphqlPractice;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.morshed.SpringGraphqlPractice.controller.designation.DesignationFetcher;
import com.morshed.dgs.generated.client.DesignationProjectionRoot;
import com.morshed.dgs.generated.client.DesignationsGraphQLQuery;
import com.morshed.dgs.generated.types.Designation;
import com.netflix.graphql.dgs.DgsQueryExecutor;
import com.netflix.graphql.dgs.autoconfig.DgsAutoConfiguration;
import com.netflix.graphql.dgs.client.codegen.GraphQLQueryRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.util.LinkedHashMap;
import java.util.List;


@SpringBootTest(classes = {DgsAutoConfiguration.class, DesignationFetcher.class})
public class DesignationFetcherTest {
    @Autowired
    DgsQueryExecutor dgsQueryExecutor;

    @Test
    void designations() {
        GraphQLQueryRequest graphQLQueryRequest = new GraphQLQueryRequest(
                new DesignationsGraphQLQuery.Builder().queryName("designations").build(),
                new DesignationProjectionRoot().title()
        );
        List<LinkedHashMap> outputList = dgsQueryExecutor.executeAndExtractJsonPathAsObject(graphQLQueryRequest.serialize(), "data.designations[*]", List.class);
        ObjectMapper objectMapper = new ObjectMapper();
        List<Designation> designations = outputList.stream().map(m -> objectMapper.convertValue(m, Designation.class)).toList();
        Assert.isTrue(designations.size() == 5, "Expected 5 designations");
        Assert.isNull(designations.get(0).getId(), "Expected null id");
        Assert.notNull(designations.get(0).getTitle(), "Expected non null title");
    }
}
