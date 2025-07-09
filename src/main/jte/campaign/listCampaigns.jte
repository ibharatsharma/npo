@import java.util.List
@import com.npo.domain.Campaign
@import com.npo.domain.WebUser

@param WebUser user
@param List<Campaign> campaigns
@param int campaignCount
@param long charityId

@template.layouts.base(content = @`
    <div class="container mt-4 border border-dark">
        <h1 class="display-4">Active Campaigns</h1>
        <div class="btn-toolbar mb-3" role="toolbar" aria-label="Toolbar with button groups">
            <div class="btn-group me-2 " role="group" aria-label="First group">
                <a href="/charities/${charityId}" class="btn btn-primary me-1"><i class="bi bi-house-door"></i></a>
                <a href="/charities/${charityId}/campaigns/new" class="btn btn-primary me-1"><i class="bi bi-pencil-square"></i>New Campaign</a>
            </div>
        </div>
        @template.campaign.campaignTable(campaigns = campaigns, charityId = charityId)
    </div>
`, title = "Campaigns", user = user)
