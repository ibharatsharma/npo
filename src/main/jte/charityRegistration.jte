@import com.npo.charity.CharityDto
@import com.npo.common.DateFormatter

@param CharityDto charity

@template.layouts.base(content = @`
    <div class="container mt-4">
        <div class="jumbotron bg-light p-5 rounded">
            <h1 class="display-4">Charity Registration</h1>
            <p class="lead">Register your charity with us.</p>
            <hr class="my-4">
            <form action="/charities/registeration" method="POST">

                <div class="col-md-6 mb-3 mt-3">
                    <label for="name" class="form-label">Charity Name:</label>
                    <input type="text"
                           class="form-control"
                           id="name"
                           placeholder="Charity name"
                           name="name"
                           value="${charity.getName()}">
                </div>

                <hr/>
                <button type="submit" class="btn btn-primary">Submit</button>
            </form>
        </div>
    </div>
`)
