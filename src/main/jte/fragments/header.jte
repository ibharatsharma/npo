@import com.npo.domain.WebUser

@param WebUser user

<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <div class="container-fluid">
        <a class="navbar-brand" href="/">U.K. Charities</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav">
                <li class="nav-item">
                    <a class="nav-link active" href="/">Home</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link active" href="/charities">Charities</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link active" href="/charities/registration">Charity Registration</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/members/registration">Join U.K. Charities</a>
                </li>
                <li class="nav-item">
                    <p style="color:white">${user.toString()}</p>
                </li>
            </ul>
            <ul class="navbar-nav ms-auto">
                @if(user.username().equalsIgnoreCase("NONE"))
                    <li class="nav-item badge text-bg-secondary">
                        <a class="nav-link" href="/login">Login</a>
                    </li>
                @else
                    <li class="nav-item badge text-bg-secondary">
                        <a class="nav-link" href="/logout">logout</a>
                    </li>
                @endif
            </ul>
            <div class="d-flex badge text-bg-secondary">
                ${user.username()}
            </div>
        </div>
    </div>
</nav>