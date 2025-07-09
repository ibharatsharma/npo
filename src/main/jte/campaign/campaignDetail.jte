@import java.util.List
@import com.npo.domain.Campaign
@import com.npo.domain.WebUser

@param WebUser user
@param long charityId
@param Campaign campaign

@template.layouts.base(content = @`
    <div class="container mt-5">
        <h3 class="display-6">Campaign</h3>
        <div class="row">
            <div class="col-sm-6">
                <div class="btn-toolbar mb-3" role="toolbar" aria-label="Toolbar with button groups">
                    <div class="btn-group me-2 " role="group" aria-label="Toolbar">
                        <a href="/charities/${charityId}/campaigns/${campaign.getId()}/events/new" class="btn btn-primary me-1">
                            <i class="bi bi-pencil-square"></i> New Event
                        </a>
                        <a href="/charities/${charityId}/campaigns/${campaign.getId()}/events" class="btn btn-primary me-1">Events</a>
                    </div>
                </div>
                <div class="card shadow-sm">
                    <div class="card-header bg-primary text-white">
                        <h4 class="mb-0">${campaign.getTitle()}</h4>
                    </div>
                    <div class="card-body">
                        <p class="card-text fs-5">${campaign.getDescription()}</p>

                        <div class="mt-3">
                <span class="badge bg-secondary">
                    Created on: --
                </span>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-sm-6">
                <div hx-get="/charities/${charityId}/campaigns/${campaign.getId()}/events"
                     hx-trigger="load delay:1s"
                     hx-swap="outerHTML">
                    <img class="htmx-indicator" src="/static/spinner.gif">
                </div>
            </div>

        </div>
    </div>

`, title = "Campaign", user = user)
