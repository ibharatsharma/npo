@import java.util.List
@import com.npo.domain.Campaign
@import com.npo.domain.WebUser

@param WebUser user
@param long charityId
@param Campaign campaign

@template.layouts.base(content = @`
    <div class="container mt-5">
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
`, title = "Campaign", user = user)
