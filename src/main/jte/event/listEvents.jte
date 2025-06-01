@import java.util.List
@import com.npo.domain.Event

@param String currentUsername = null
@param List<Event> events
@param int eventCount

@template.layouts.base(content = @`
    <div class="container mt-4">
        <h1 class="display-4">${eventCount} Events</h1>
        @for(Event event: events)
            <div class="card mb-3" style="width: 100%;">
                <div class="card-body">
                    <h5 class="card-title">${event.getName()}</h5>
                    <h6 class="card-subtitle mb-2 text-body-secondary">Card subtitle</h6>
                    <p class="card-text">${event.getDescription()}</p>
                    <a href="#" class="card-link">Card link</a>
                    <a href="#" class="card-link">Another link</a>
                </div>
            </div>
        @endfor
    </div>
`, title = "Events", currentUsername = currentUsername)
