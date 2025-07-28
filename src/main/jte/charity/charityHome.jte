@import com.npo.domain.Charity
@import com.npo.domain.Event
@import com.npo.domain.WebUser
@import java.util.Set

@param WebUser user
@param Charity charity

@template.layouts.base(content = @`
    <div class="container mt-4">
        <div class="row">
            @template.charity.charityDetails(charity = charity)
        </div>
        <div class="row">
            <div class="col-md-6">
                <h3>Active Campaigns</h3>
                <div class="btn-toolbar mb-3" role="toolbar" aria-label="Toolbar with button groups">
                    <div class="btn-group me-2 " role="group" aria-label="Toolbar">
                        <a href="/charities/${charity.getId()}/events/new" class="btn btn-primary me-1"><i class="bi bi-pencil-square"></i> New Event</a>
                        <a href="/charities/${charity.getId()}/campaigns" class="btn btn-primary me-1">Campaigns</a>
                        <a href="/charities/${charity.getId()}/events" class="btn btn-primary me-1">Show Events</a>
                    </div>
                </div>
                <div hx-get="/charities/${charity.getId()}/campaigns?internal=true"
                     hx-trigger="load delay:300ms"
                     hx-swap="outerHTML">
                    <img class="htmx-indicator" src="/static/spinner.gif">
                </div>
            </div>
            <div class="col-md-6">
                Show details of events here
            </div>
        </div>
    </div>
`, title = "Home", user = user)
