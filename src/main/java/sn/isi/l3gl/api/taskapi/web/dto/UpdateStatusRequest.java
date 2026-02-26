package sn.isi.l3gl.api.taskapi.web.dto;

import sn.isi.l3gl.core.taskcore.domain.TaskStatus;

public class UpdateStatusRequest {

    private TaskStatus status;

    public TaskStatus getStatus() {
        return status;
    }

    public void setStatus(TaskStatus status) {
        this.status = status;
    }
}
