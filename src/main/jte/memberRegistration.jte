@import com.npo.domain.WebUser
@import com.npo.member.MemberDto
@import com.npo.common.DateFormatter

@param MemberDto m
@param WebUser user

@template.layouts.base(content = @`
    <div class="container mt-4">
        <div class="jumbotron bg-light p-5 rounded">
            <h1 class="display-4">Member Registration</h1>
            <p class="lead">Become a member by providing some basic info.</p>
            <hr class="my-4">
            <form action="/members/registration" method="POST">
                <div class="row">
                    <div class="col-md-6 mb-3 mt-3">
                        <label for="firstName" class="form-label">First Name:</label>
                        <input type="text"
                               class="form-control"
                               id="firstName"
                               placeholder="Enter your first name"
                               name="firstName"
                               value="${m.firstName()}">
                    </div>
                    <div class="col-md-6 mb-3 mt-3">
                        <label for="lastName" class="form-label">Last Name:</label>
                        <input type="text"
                               class="form-control"
                               id="lastName"
                               placeholder="Enter your last name"
                               name="lastName"
                               value="${m.lastName()}">
                    </div>
                </div>
                <div class="col-md-6 mb-3">
                    <label for="dob" class="form-label">Date of Birth:</label>
                    <input type="date" class="form-control" id="dob" placeholder="Date of Birth" name="dob"
                           value="${DateFormatter.format(m.dob(),"dd-MM-yyyy")}">
                </div>
                <div class="col-md-6 form-check mb-3">
                    <label class="form-check-label" for="radio1">Gender:</label>
                    <div class="form-check">
                        <input type="radio" class="form-check-input" id="gender1" name="gender" value="Male" >Male
                        <label class="form-check-label" for="radio1"></label>
                    </div>
                    <div class="form-check">
                        <input type="radio" class="form-check-input" id="gender2" name="gender" value="Female">Female
                        <label class="form-check-label" for="radio1"></label>
                    </div>
                    <div class="form-check">
                        <input type="radio" class="form-check-input" id="gender2" name="gender" value="Other" >Other
                        <label class="form-check-label" for="radio1"></label>
                    </div>
                </div>
                <hr />
                <button type="submit" class="btn btn-primary">Submit</button>
            </form>
        </div>
    </div>
`, title = "Member Registration", user = user)
