@import com.npo.domain.WebUser

@param gg.jte.Content content
@param String title
@param WebUser user

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>${title}</title>
    <link href="/webjars/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="/webjars/bootstrap-icons/font/bootstrap-icons.css" rel="stylesheet">
</head>
<body>
    @template.fragments.header(user = user)
    <main>
        ${content}
    </main>
    <!-- Bootstrap JS -->
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
    <script src="/webjars/htmx.org/dist/htmx.min.js"></script>
</body>
</html>
