@import com.npo.events.EventDto
@import com.npo.common.DateFormatter
@import com.npo.domain.WebUser
@import com.npo.domain.EventRecurrenceType

@param EventDto e
@param Long charityId
@param WebUser user

@template.layouts.base(content = @`
    <div class="container mt-4">
        <div class="btn-toolbar mb-3" role="toolbar" aria-label="Toolbar with button groups">
            <div class="btn-group me-2 " role="group" aria-label="First group">
                <a href="/charities/${charityId}" class="btn btn-primary me-1">Back to Dashboard</a>
                <a href="/charities/${charityId}/events" class="btn btn-primary me-1">View All Events</a>
            </div>
        </div>
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
                               value="${e.getName()}" required>
                    </div>
                    <div class="mb-3 mt-3">
                        <label for="description" class="form-label">Description:</label>
                        <textarea class="form-control"
                               id="description"
                               placeholder="Description of the event.."
                               name="description">${e.getDescription()}</textarea>
                    </div>
                </div>
                <div class="mb-3 mt-3">
                    <label for="location" class="form-label">Event Location:</label>
                    <input type="text"
                           class="form-control"
                           id="location"
                           placeholder="Event location"
                           name="location"
                           value="${e.getName()}" required>
                </div>
                <div class="col-md-6 mb-3">
                    <label for="isRecurring" class="form-label">Make Recurring Event:</label>
                    <input type="checkbox"
                           class="form-check-input"
                           id="isRecurring"
                           name="isRecurring"
                           value="${e.getIsRecurring()}">
                </div>

                <div class="col-md-6 mb-3">
                    <label for="recurrenceType" class="form-label">Recurrence:</label>
                    <select class="form-select"
                           id="recurrenceType"
                           name="recurrenceType">
                        @for(EventRecurrenceType type : EventRecurrenceType.values())
                            <option>${type.name()}</option>
                        @endfor
                    </select>
                </div>

                <div class="col-md-6 mb-3">
                    <label for="startDate" class="form-label">Start Date:</label>
                    <input type="datetime-local"
                           class="form-control"
                           id="startDate"
                           placeholder="Start Date"
                           name="startDate"
                           value="${DateFormatter.formatTimestamp(e.getStartDate(),"dd-MM-yyyy HH:mm:ss")}"
                           required>
                </div>
                <div class="col-md-6 mb-3">
                    <label for="endDate" class="form-label">End Date:</label>
                    <input type="datetime-local"
                           class="form-control"
                           id="endDate"
                           placeholder="End Date"
                           name="endDate"
                           value="${DateFormatter.formatTimestamp(e.getEndDate(),"dd-MM-yyyy HH:mm:ss")}"
                           required>
                </div>
                <button type="submit" class="btn btn-primary">Submit</button>
            </form>
        </div>
    </div>
`, title = "New Event", user = user)
