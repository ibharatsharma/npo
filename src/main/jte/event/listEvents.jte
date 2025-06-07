@import java.util.List
@import com.npo.domain.Event
@import com.npo.domain.WebUser

@param WebUser user
@param List<Event> events
@param int eventCount
@param long charityId

@template.layouts.base(content = @`
    <div class="container mt-4">
        <h1 class="display-4">Upcoming Events</h1>
        <div class="btn-toolbar mb-3" role="toolbar" aria-label="Toolbar with button groups">
            <div class="btn-group me-2 " role="group" aria-label="First group">
                <a href="/charities/${charityId}" class="btn btn-primary me-1">Back to Dashboard</a>
                <a href="/charities/${charityId}/events/new" class="btn btn-primary me-1">Create new Event</a>
            </div>
        </div>
        @for(Event event: events)
            <div class="card mb-3" style="width: 100%;">
                <div class="card-body">
                    <h5 class="card-title">${event.getName()}</h5>
                    <h6 class="card-subtitle mb-2 text-body-secondary">${event.getId()}Card subtitle</h6>
                    <p class="card-text">${event.getDescription()}</p>
                    <a href="#" class="btn btn-primary btn-sm">Update Event</a>
                    <a href="/charities/${charityId}/events/${event.getId()}" class="btn btn-primary btn-sm">Show Details</a>
                </div>
            </div>
        @else
            <h3>No events!</h3>
        @endfor
    </div>
`, title = "Events", user = user)
