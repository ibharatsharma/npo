@param com.npo.domain.Charity charity

<div class="card">
    <div class="card-body">
        <h5 class="card-title">${charity.getName()}</h5>
        <h6 class="card-subtitle mb-2 text-body-secondary">Registration Number: ${charity.getRegistrationNumber()}</h6>
        <p class="card-text">${charity.getPurpose()}</p>
        <p class="card-text">Address: ${charity.getAddress()}</p>
        <a href="/charities/${charity.getId()}" class="card-link">More details about ${charity.getName()}</a>
    </div>
</div>
