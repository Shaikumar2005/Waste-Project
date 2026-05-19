package com.smartwaste.backend.dto;

public class AdminReportDTO {

    private long totalRoutes;
    private long totalCollectors;
    private long totalAssignments;
    private long activeAssignments;
    private long completedAssignments;

    public long getTotalRoutes() {
        return totalRoutes;
    }

    public void setTotalRoutes(long totalRoutes) {
        this.totalRoutes = totalRoutes;
    }

    public long getTotalCollectors() {
        return totalCollectors;
    }

    public void setTotalCollectors(long totalCollectors) {
        this.totalCollectors = totalCollectors;
    }

    public long getTotalAssignments() {
        return totalAssignments;
    }

    public void setTotalAssignments(long totalAssignments) {
        this.totalAssignments = totalAssignments;
    }

    public long getActiveAssignments() {
        return activeAssignments;
    }

    public void setActiveAssignments(long activeAssignments) {
        this.activeAssignments = activeAssignments;
    }

    public long getCompletedAssignments() {
        return completedAssignments;
    }

    public void setCompletedAssignments(long completedAssignments) {
        this.completedAssignments = completedAssignments;
    }
}