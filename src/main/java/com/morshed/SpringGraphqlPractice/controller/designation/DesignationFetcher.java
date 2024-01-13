package com.morshed.SpringGraphqlPractice.controller.designation;

import com.morshed.SpringGraphqlPractice.entity.Designation;
import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsQuery;
import com.netflix.graphql.dgs.InputArgument;

import java.util.List;
import java.util.UUID;

@DgsComponent
public class DesignationFetcher {
    private final List<Designation> designations = List.of(
            new Designation(UUID.randomUUID(), "Software Engineer"),
            new Designation(UUID.randomUUID(), "Senior Software Engineer"),
            new Designation(UUID.randomUUID(), "Team Lead"),
            new Designation(UUID.randomUUID(), "Project Manager"),
            new Designation(UUID.randomUUID(), "Senior Project Manager")
    );

    @DgsQuery
    public List<Designation> designations() {
        return designations;
    }

    @DgsQuery
    public Designation designation(@InputArgument String id) {
        UUID uuid = UUID.fromString(id);
        return designations.stream().filter(d -> d.getId().equals(uuid)).findFirst().orElse(null);
    }
}
