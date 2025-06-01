@import com.npo.events.EventDto
@import com.npo.common.DateFormatter

@param EventDto e
@param String currentUsername = null
@param Long charityId

@template.layouts.base(content = @`
    <div class="container mt-4">
        <div class="jumbotron bg-primary-subtle p-5 rounded">
            <h1 class="display-4">Create New Event</h1>
            <p class="lead">Provide details to create an event.</p>
            <hr class="my-4">
            <form action="/charities/${charityId}/events" method="POST">
                <div class="row">
                    <div class="mb-3 mt-3">
                        <label for="name" class="form-label">Event Name:</label>
                        <input type="text"
                               class="form-control"
                               id="name"
                               placeholder="Enter Event name"
                               name="name"
                               value="${e.getName()}">
                    </div>
                    <div class="mb-3 mt-3">
                        <label for="description" class="form-label">Description:</label>
                        <textarea class="form-control"
                               id="description"
                               placeholder="Description of the event.."
                               name="description">${e.getDescription()}</textarea>
                    </div>
                </div>
                <div class="col-md-6 mb-3">
                    <label for="startDate" class="form-label">Start Date:</label>
                    <input type="datetime-local"
                           class="form-control"
                           id="startDate"
                           placeholder="Start Date"
                           name="startDate"
                           value="${DateFormatter.formatTimestamp(e.getStartDate(),"dd-MM-yyyy HH:mm:ss")}">
                </div>
                <div class="col-md-6 mb-3">
                    <label for="endDate" class="form-label">End Date:</label>
                    <input type="datetime-local"
                           class="form-control"
                           id="endDate"
                           placeholder="End Date"
                           name="endDate"
                           value="${DateFormatter.formatTimestamp(e.getEndDate(),"dd-MM-yyyy HH:mm:ss")}">
                </div>
                <button type="submit" class="btn btn-primary">Submit</button>
            </form>
        </div>
    </div>
`, title = "New Event", currentUsername = currentUsername)
