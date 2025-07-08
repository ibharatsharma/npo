@import com.npo.domain.Campaign
@import java.util.List

@param List<Campaign> campaigns
@param Long charityId

<tbody>
@for(Campaign campaign: campaigns)
    <tr id="row-${campaign.getId()}">
        <td>${campaign.getTitle()}</td>
        <td>${campaign.getDescription()}</td>
        <td>
            <button
                    hx-delete="/charities/${charityId}/campaigns/${campaign.getId()}"
                    hx-target="#row-${campaign.getId()}"
                    hx-swap="delete"
                    hx-confirm="Are you sure you want to delete '${campaign.getTitle()}' campaign?">
                Delete
            </button>
        </td>
    </tr>
@else
    <tr>
        <td colspan="3">
            <strong>No Campaigns!</strong>
        </td>
    </tr>
@endfor
</tbody>