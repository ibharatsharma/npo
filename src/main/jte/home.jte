@param String currentUsername = null

@template.layouts.base(content = @`
<div class="container mt-4">
    <div class="jumbotron text-center bg-light p-5 rounded">
        <h1 class="display-4">Welcome to My Spring Boot 3 Application!</h1>
        <p class="lead">This is your new homepage, styled beautifully with Bootstrap.</p>
        <hr class="my-4">
        <p>Explore the features or navigate using the menu above.</p>
        <a class="btn btn-primary btn-lg" href="/features" role="button">Explore Features</a>
        <p>${currentUsername}</p>
    </div>
</div>
`, title = "Home", currentUsername = currentUsername)
