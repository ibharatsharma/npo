@import com.npo.domain.Charity

@param Charity charity = null

<div class="accordion accordion-flush" id="accordionFlush">
    <div class="accordion-item">
        <h2 class="accordion-header">
            <button class="accordion-button collapsed bg-secondary-subtle fs-5"
                    type="button"
                    data-bs-toggle="collapse"
                    data-bs-target="#flush-collapseOne"
                    aria-expanded="false"
                    aria-controls="flush-collapseOne">
                ${charity.getName()}
            </button>
        </h2>
        <div id="flush-collapseOne" class="accordion-collapse collapse" data-bs-parent="#accordionFlush">
            <div class="accordion-body">
                <p><strong>Address: </strong>${charity.getAddress()}</p>
                <p><strong>Registration Number: </strong>${charity.getRegistrationNumber()}</p>
                <p><strong>Contact Information: </strong>${charity.getContactInfo()}</p>
            </div>
        </div>
    </div>
</div>
