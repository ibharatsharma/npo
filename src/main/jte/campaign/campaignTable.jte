@import com.npo.domain.Campaign
@import java.util.List

@param List<Campaign> campaigns
@param Long charityId

<table class="table table-hover">
    <thead>
    <tr>
        <th>Campaign Title</th>
        <th>Description</th>
        <th>Actions</th>
    </tr>
    </thead>
    @template.campaign.campaignRow(campaigns = campaigns, charityId = charityId)
</table>
