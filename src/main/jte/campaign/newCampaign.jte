@import com.npo.campaign.CampaignDto

@import com.npo.common.DateFormatter
@import com.npo.domain.WebUser

@param CampaignDto dto
@param Long charityId
@param WebUser user

@template.layouts.base(content = @`
    <div class="container mt-4">
        <div class="btn-toolbar mb-3" role="toolbar" aria-label="Toolbar with button groups">
            <div class="btn-group me-2 " role="group" aria-label="First group">
                <a href="/charities/${charityId}" class="btn btn-primary me-1">Charity Home</a>
                <a href="/charities/${charityId}/campaigns" class="btn btn-primary me-1">View All Campaigns</a>
            </div>
        </div>
        <div class="jumbotron bg-primary-subtle p-5 rounded">
            <h1 class="display-4">Create a new Campaign</h1>
            <p class="lead">Provide details to create a new Campaign.</p>
            <hr class="my-4">
            <form action="/charities/${charityId}/campaigns" method="POST">
                <div class="row">
                    <div class="mb-3 mt-3">
                        <label for="campaignTitle" class="form-label">Campaign Title:</label>
                        <input type="text"
                               class="form-control"
                               id="campaignTitle"
                               placeholder="Enter Campaign title"
                               name="campaignTitle"
                               value="${dto.getCampaignTitle()}" required>
                    </div>
                    <div class="mb-3 mt-3">
                        <label for="description" class="form-label">Description:</label>
                        <textarea class="form-control"
                               id="description"
                               placeholder="Description of the event.."
                               name="description">${dto.getDescription()}</textarea>
                    </div>
                </div>
                <button type="submit" class="btn btn-primary">Submit</button>
            </form>
        </div>
    </div>
`, title = "New Event", user = user)
