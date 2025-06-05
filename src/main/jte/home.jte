@import com.npo.domain.WebUser

@param WebUser user

@template.layouts.base(content = @`
<div class="container mt-4">
    <div class="jumbotron text-center bg-light p-5 rounded">
        <h1 class="display-4">Welcome to My Spring Boot 3 Application!</h1>
        <p class="lead">This is your new homepage, styled beautifully with Bootstrap.</p>
        <hr class="my-4">
        <p>Explore the features or navigate using the menu above.</p>
        <a class="btn btn-primary btn-lg" href="/features" role="button">Explore Features</a>
        <p>${user.toString()}</p>
        @if(user.roles().contains("ADMIN"))
            <h2>you are an admin</h2>
        @endif
    </div>
</div>
`, title = "Home", user = user)
