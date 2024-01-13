package com.morshed.SpringGraphqlPractice;

import com.morshed.SpringGraphqlPractice.controller.designation.DesignationFetcher;
import com.netflix.graphql.dgs.DgsQueryExecutor;
import com.netflix.graphql.dgs.autoconfig.DgsAutoConfiguration;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = {DgsAutoConfiguration.class, DesignationFetcher.class})
public class DesignationFetcherTest {
    @Autowired
    DgsQueryExecutor dgsQueryExecutor;

    @Test
    void designations() {

    }
}
