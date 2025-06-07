@import com.npo.domain.Event
@import com.npo.domain.WebUser
@import com.npo.common.DateFormatter

@param WebUser user
@param Event event
@param Long charityId

@template.layouts.base(content = @`
    <div class="container mt-4">
        <h1 class="display-4">Event Details</h1>
        <div class="card" style="width: 100%;">
            <div class="card-body">
                <h5 class="card-title">${event.getName()}</h5>
                <h6 class="card-subtitle mb-2 text-body-secondary">Card subtitle</h6>
                <p class="card-text">${event.getDescription()}</p>
                <p class="card-text"><strong>Location: </strong>${event.getLocation()}</p>
                <p class="card-text"><strong>Time: </strong>${DateFormatter.formatTimestampWithDayOfWeek(event.getStartDate())} <strong>to</strong> ${DateFormatter.formatTimestampWithDayOfWeek(event.getEndDate())}</p>
                <p class="card-text"><strong>Duration: </strong>${DateFormatter.duration(event.getStartDate(), event.getEndDate())}</p>
                <p class="card-text"><strong>Category: </strong>${event.getCategory() == null ? "--" : event.getCategory()}</p>
                <p class="card-text"><strong>Organizer: </strong>${event.getOrganizer() == null ? "--" : event.getOrganizer()}</p>
                <p class="card-text"><strong>Organizer: </strong>${(event.getIsPrivate() == null || event.getIsPrivate()) ? "Private" : "Public"}</p>
                <div class="btn-toolbar mb-3" role="toolbar" aria-label="Toolbar with button groups">
                    <div class="btn-group me-2 " role="group" aria-label="First group">
                        <a href="/charities/${charityId}" class="btn btn-primary me-1 btn-sm">Back to Dashboard</a>
                        <a href="/charities/${charityId}/events" class="btn btn-primary me-1 btn-sm">Show Events</a>
                    </div>
                </div>
            </div>
        </div>
    </div>
`, title = "Event Details", user = user)
