@import com.npo.domain.Charity
@import com.npo.domain.Event

@param String currentUsername = null
@param com.npo.domain.Charity charity

@template.layouts.base(content = @`
    <div class="container mt-4">
        <h1 class="display-4">Home Of ${charity.getName()}</h1>
        <div class="row">
            <div class="col-md-6">
                <p><strong>Address: </strong>${charity.getAddress()}</p>
                <p><strong>Registration Number: </strong>${charity.getRegistrationNumber()}</p>
                <p><strong>Contact Information: </strong>${charity.getContactInfo()}</p>
            </div>
            <div class="col-md-6">
                <h3>Events</h3>
                <a href="/charities/${charity.getId()}/events/new" class="btn btn-primary">Create new Event</a>
                @for(Event event : charity.getEvents())
                    @template.charity.eventRow(event = event)
                @endfor
            </div>
        </div>
    </div>
`, title = "Home", currentUsername = currentUsername)
