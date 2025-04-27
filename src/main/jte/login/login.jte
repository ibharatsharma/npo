@param Boolean error = false
@param String errorMessage = null
@param Boolean logout = false
@param String logoutMessage = null
@param org.springframework.security.web.csrf.CsrfToken csrf = null

@template.layouts.base(content = @`

    <div class="container mt-5 ">
        <div class="row justify-content-center">
            <div class="col-md-4 bg-secondary-subtle p-4">
                <h3 class="text-center mb-4">Sing in to your account</h3>
                <hr />
                @if(error)
                <div class="alert alert-danger" role="alert">
                    ${errorMessage != null? errorMessage : "Invalid username or password."}
                </div>
                @endif
                @if(logout)
                    <div class="alert alert-info" role="alert">
                        ${logoutMessage != null? logoutMessage : "You have been logged out."}
                    </div>
                @endif
                <form method="post" action="/login">
                    @if(csrf != null)
                        <input type="hidden" name="${csrf.getParameterName()}" value="${csrf.getToken()}">
                    @endif
                    <div class="mb-3">
                        <label for="username" class="form-label">Username</label>
                        <input type="text" class="form-control" name="username" id="username" required>
                    </div>
                    <div class="mb-3">
                        <label for="password" class="form-label">Password</label>
                        <input type="password" class="form-control" name="password" id="password" required>
                    </div>
                    <button type="submit" class="btn btn-primary w-100">Login</button>
                </form>
            </div>
        </div>
    </div>
`, title = "Login")
