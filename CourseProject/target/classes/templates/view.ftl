<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <!-- CSS only -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
</head>
<body style="background: #212529">

<nav class="navbar sticky-top navbar-expand-lg navbar-dark bg-dark" style="font-size: 20px;">
    <a class="navbar-brand ml-2" href="#">Navbar</a>

    <div class="collapse navbar-collapse" id="navbarNavDropdown">
        <ul class="navbar-nav">
            <li class="nav-item">
                <a class="nav-link active" href="/view/?page=0&size=3">View page</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/students/">Student page</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/examinerPage/">Examiner page</a>
            </li>
        </ul>
    </div>
    <a class="navbar-brand mr-2" href="/view/examiners/">Examiners</a>
    <a class="navbar-brand mr-2" href="/view/specialties/">Specialties</a>
</nav>

<div>
    <table class="table table-dark" style="text-align: center">
        <thead style="font-size: 18px;">
            <th>First name</th>
            <th>Last name</th>
            <th>Speciality</th>
            <th class="border border-light">Subject</th>
            <th class="border border-light">Points</th>
        </thead>
        <#list page.content as student>
            <tr>
                <td rowspan="3">${student.firstName}</td>
                <td rowspan="3">${student.lastName}</td>
                <td rowspan="3">${student.specialty.name}</td>
                <td class="border border-light">${student.specialty.subject1.name}</td>
                <td class="border border-light">${student.specialty.subject1.points}</td>
            </tr>
            <tr>
                <td class="border border-light">${student.specialty.subject2.name}</td>
                <td class="border border-light">${student.specialty.subject2.points}</td>
            </tr>
            <tr>
                <td class="border border-light">${student.specialty.subject3.name}</td>
                <td class="border border-light">${student.specialty.subject3.points}</td>
            </tr>
        </#list>
    </table>

    <ul class="pagination justify-content-center">
        <li class="page-item disabled">
            <a class="page-link" href="#" tabindex="-1">Pages</a>
        </li>
        <#list 1..page.getTotalPages() as p>
            <#if p - 1 == page.getNumber()>
                <li class="page-item active">
                    <a class="page-link" href="#" tabindex="-1">${p}</a>
                </li>
            <#else>
                <li class="page-item">
                    <a class="page-link" href="${url}?page=${p - 1}&size=${3}" tabindex="-1">${p}</a>
                </li>
            </#if>
        </#list>
    </ul>
</div>
</body>
</html>