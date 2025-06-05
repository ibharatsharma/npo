@import com.npo.domain.WebUser
@param WebUser user

@template.layouts.base(content = @`
    <div class="container mt-4">
        <h1 class="display-4">Event Details</h1>
    </div>
`, title = "Event Details", user = user)
