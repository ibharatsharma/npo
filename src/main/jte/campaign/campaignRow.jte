@import com.npo.domain.Campaign
@import java.util.List

@param List<Campaign> campaigns
@param Long charityId

<tbody>
@for(Campaign campaign: campaigns)
    <tr id="row-${campaign.getId()}">
        <td><a href="/charities/${charityId}/campaigns/${campaign.getId()}">${campaign.getTitle()}</a></td>
        <td>${campaign.getDescription()}</td>
        <td>
            <button class="btn btn-outline-secondary"
            hx-put="/charities/${charityId}/campaigns/${campaign.getId()}"
            hx-target="">
                <i class="bi bi-pencil"></i>
            </button>
            <button class="btn btn-outline-secondary"
                    hx-delete="/charities/${charityId}/campaigns/${campaign.getId()}"
                    hx-target="#row-${campaign.getId()}"
                    hx-swap="delete delay:3s"
                    hx-confirm="Are you sure you want to delete '${campaign.getTitle()}' campaign?">
                <i class="bi bi-archive"></i>
            </button>
        </td>
    </tr>
@else
    <tr>
        <td colspan="3">
            <div class="border mx-auto shadow ps-3" style="width:150px">
                <strong class="text-info">No Campaigns!</strong>
            </div>
        </td>
    </tr>
@endfor
</tbody>