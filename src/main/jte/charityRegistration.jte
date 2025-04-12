@import com.npo.charity.CharityDto
@import com.npo.common.DateFormatter

@param CharityDto charity

@template.layouts.base(content = @`
    <div class="container mt-4">
        <div class="jumbotron bg-light p-5 rounded">
            <h1 class="display-4">Charity Registration</h1>
            <p class="lead">Register your charity with us.</p>
            <hr class="my-4">
            <form action="/charities/registration" method="POST">

                <div class="mb-3 mt-3">
                    <label for="name" class="form-label">Name:</label>
                    <input type="text"
                           class="form-control"
                           id="name"
                           placeholder="Charity name"
                           name="name"
                           value="${charity.getName()}">
                </div>
                <div class="mb-3 mt-3">
                    <label for="registrationNumber" class="form-label">Registration Number:</label>
                    <input type="text"
                           class="form-control"
                           id="registrationNumber"
                           placeholder="Charity Registration Number"
                           name="registrationNumber"
                           value="${charity.getRegistrationNumber()}">
                </div>
                <div class="mb-3 mt-3">
                    <label for="purpose" class="form-label">Purpose:</label>
                    <textarea class="form-control"
                              id="purpose"
                              placeholder="Purpose of the Charity.."
                              name="purpose">${charity.getPurpose()}</textarea>
                </div>
                <div class="mb-3 mt-3">
                    <label for="address" class="form-label">Address:</label>
                    <input type="text"
                           class="form-control"
                           id="address"
                           placeholder="Charity address"
                           name="address"
                           value="${charity.getAddress()}">
                </div>
                <div class="mb-3 mt-3">
                    <label for="contactInfo" class="form-label">Contact Info / Phone:</label>
                    <input type="text"
                           class="form-control"
                           id="contactInfo"
                           placeholder="Charity Registration Number"
                           name="contactInfo"
                           value="${charity.getContactInfo()}">
                </div>
                <hr/>
                <button type="submit" class="btn btn-primary">Submit</button>
            </form>
        </div>
    </div>
`)
