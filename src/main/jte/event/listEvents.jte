@import java.util.List
@import com.npo.domain.Event
@import com.npo.domain.EventRecurrence
@import com.npo.domain.WebUser
@import com.npo.common.DateFormatter

@param WebUser user
@param List<Event> events
@param int eventCount
@param long charityId
@param String campaignId

<div class="container mt-4">
    <h3 class="display-6">Upcoming Events</h3>
    <div class="btn-toolbar mb-3" role="toolbar" aria-label="Toolbar with button groups">
        <div class="btn-group me-2 " role="group" aria-label="First group">
            <a href="/charities/${charityId}" class="btn btn-primary me-1"><i class="bi bi-house-door"></i></a>
            <a href="/charities/${charityId}/campaigns/${campaignId}/events/new" class="btn btn-primary me-1"><i class="bi bi-pencil-square"></i> New Event</a>
        </div>
    </div>
    @for(Event event: events)
        ${event.getRecurrences().size()}
        <div class="card mb-3" style="width: 100%;">
            <div class="card-body">
                <h5 class="card-title">${event.getName()}</h5>
                <h6 class="card-subtitle mb-2 text-body-secondary">${event.getId()}Card subtitle</h6>
                <p class="card-text">${event.getDescription()}</p>
                <a href="#" class="btn btn-primary btn-sm"><i class="bi bi-pencil"></i> Edit</a>
                <a href="/charities/${charityId}/campaigns/${campaignId}/events/${event.getId()}"
                   class="btn btn-primary btn-sm"><i class="bi bi-card-heading"></i> Details</a>
                <a href="/charities/${charityId}/campaigns/${campaignId}/events/${event.getId()}"
                   class="btn btn-primary btn-sm"><i class="bi bi-trash"></i> Delete</a>
            </div>
        </div>
        <ol class="list-group list-group-numbered">
        @for(EventRecurrence r : event.getRecurrences())

                <li class="list-group-item d-flex justify-content-between align-items-start">
                    <div class="ms-2 me-auto">
                        <div class="fw-bold">${event.getName()}</div>
                        <strong>Location: </strong>${r.getLocation()}<br/>
                        <strong>Date & Time: </strong>${DateFormatter.formatTimestampWithDayOfWeek(r.getStartDate())} to ${DateFormatter.formatTimestampWithDayOfWeek(r.getEndDate())}<br/>
                        <strong>Duration: </strong> <span class="badge text-bg-primary rounded-pill">${DateFormatter.duration(r.getStartDate(), r.getEndDate())}</span><br/>
                        <strong>Notes: </strong>${r.getNote()}
                    </div>

                </li>
        @endfor
        </ol>
    @else
        <h3>No events!</h3>
    @endfor
</div>
