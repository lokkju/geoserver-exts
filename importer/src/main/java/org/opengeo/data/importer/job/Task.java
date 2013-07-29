package org.opengeo.data.importer.job;

import java.util.concurrent.FutureTask;

public class Task<V> extends FutureTask<V> {

    Long id;
    ProgressMonitor monitor;
    Throwable error;
    boolean recieved = false;
    boolean started = false;
    String toString;

    public Task(Job<V> job) {
        super(job);
        toString = job.toString();
        monitor = new ProgressMonitor();
        job.setMonitor(monitor);
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public ProgressMonitor getMonitor() {
        return monitor;
    }

    public Throwable getError() {
        return error;
    }

    public void setError(Throwable error) {
        this.error = error;
    }

    public void recieve() {
        recieved = true;
    }

    public boolean isRecieved() {
        return recieved;
    }

    public void started() {
        started = true;
    }

    public boolean isStarted() {
        return started;
    }

    @Override
    public String toString() {
        return toString;
    }
}
