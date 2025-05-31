@import com.npo.charity.CharityDto
@import org.springframework.validation.BindingResult

@param CharityDto charity
@param String error = null
@param String message = null
@param BindingResult bindingResult = null
@param String currentUsername = null

@template.layouts.base(content = @`
    <div class="container mt-4">
        <div class="jumbotron bg-light p-5 rounded">
            <h1 class="display-4">Charity Registration</h1>
            <p class="lead">Register your charity with us.</p>
            <hr class="my-4">
            @if(error != null)
                <div class="alert alert-danger" role="alert">
                    ${error}
                </div>
            @endif
            @if(message != null)
                <div class="alert alert-success" role="alert">
                    ${message}
                </div>
                <a class="btn btn-primary" href="/charities/registration">Register another Charity</a>
            @endif
            @if(message == null)
                <form action="/charities/registration" method="POST">

                    <div class="mb-3 mt-3">
                        <label for="name" class="form-label">Name:</label>
                        @if(bindingResult != null && bindingResult.hasFieldErrors("name"))
                            <p class="text-danger">${bindingResult.getFieldError("name").getDefaultMessage()}</p>
                        @endif
                        <input type="text"
                               class="form-control"
                               id="name"
                               placeholder="Charity name"
                               name="name"
                               value="${charity.getName()}">
                    </div>
                    <div class="mb-3 mt-3">
                        <label for="registrationNumber" class="form-label">Registration Number:</label>
                        @if(bindingResult != null && bindingResult.hasFieldErrors("registrationNumber"))
                            <p class="text-danger">${bindingResult.getFieldError("registrationNumber").getDefaultMessage()}</p>
                        @endif
                        <input type="text"
                               class="form-control"
                               id="registrationNumber"
                               placeholder="Charity Registration Number"
                               name="registrationNumber"
                               value="${charity.getRegistrationNumber()}">
                    </div>
                    <div class="mb-3 mt-3">
                        <label for="purpose" class="form-label">Purpose:</label>
                        @if(bindingResult != null && bindingResult.hasFieldErrors("purpose"))
                            <p class="text-danger">${bindingResult.getFieldError("purpose").getDefaultMessage()}</p>
                        @endif
                        <textarea class="form-control"
                                  id="purpose"
                                  placeholder="Purpose of the Charity.."
                                  name="purpose">${charity.getPurpose()}</textarea>
                    </div>
                    <div class="mb-3 mt-3">
                        <label for="address" class="form-label">Address:</label>
                        @if(bindingResult != null && bindingResult.hasFieldErrors("address"))
                            <p class="text-danger">${bindingResult.getFieldError("address").getDefaultMessage()}</p>
                        @endif
                        <input type="text"
                               class="form-control"
                               id="address"
                               placeholder="Charity address"
                               name="address"
                               value="${charity.getAddress()}">
                    </div>
                    <div class="mb-3 mt-3">
                        <label for="contactInfo" class="form-label">Contact Info / Phone:</label>
                        @if(bindingResult != null && bindingResult.hasFieldErrors("contactInfo"))
                            <p class="text-danger">${bindingResult.getFieldError("contactInfo").getDefaultMessage()}</p>
                        @endif
                        <input type="text"
                               class="form-control"
                               id="contactInfo"
                               placeholder="Charity Registration Number"
                               name="contactInfo"
                               value="${charity.getContactInfo()}">
                    </div>
                    <div class="mb-3 mt-3">
                        <label for="email" class="form-label">Charity's Email Id:</label>
                        @if(bindingResult != null && bindingResult.hasFieldErrors("email"))
                            <p class="text-danger">${bindingResult.getFieldError("email").getDefaultMessage()}</p>
                        @endif
                        <input type="text"
                               class="form-control"
                               id="email"
                               placeholder="Charity's email id"
                               name="email"
                               value="${charity.getEmail()}">
                    </div>
                    <div class="mb-3 mt-3">
                        <label for="password" class="form-label">Password:</label>
                        @if(bindingResult != null && bindingResult.hasFieldErrors("password"))
                            <p class="text-danger">${bindingResult.getFieldError("password").getDefaultMessage()}</p>
                        @endif
                        <input type="text"
                               class="form-control"
                               id="password"
                               placeholder=""
                               name="password"
                               value="${charity.getPassword()}">
                    </div>
                    <div class="mb-3 mt-3">
                        <label for="confirmedPassword" class="form-label">Confirm Password:</label>
                        @if(bindingResult != null && bindingResult.hasFieldErrors("confirmedPassword"))
                            <p class="text-danger">${bindingResult.getFieldError("confirmedPassword").getDefaultMessage()}</p>
                        @endif
                        <input type="text"
                               class="form-control"
                               id="confirmedPassword"
                               placeholder=""
                               name="confirmedPassword"
                               value="${charity.getConfirmedPassword()}">
                    </div>
                    <hr/>
                    <button type="submit" class="btn btn-primary">Submit</button>
                </form>
            @endif
        </div>
    </div>
`, title = "Charity Registration", currentUsername = currentUsername)
