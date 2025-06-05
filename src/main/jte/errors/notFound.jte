@import com.npo.domain.WebUser
@param WebUser user

@template.layouts.base(content = @`
    <div class="container mt-4">
        <div class="jumbotron text-center bg-light p-5 rounded">
            <h1 class="display-4">How did you end up here?</h1>
        </div>
    </div>
`, title = "Not Found", user = user)
