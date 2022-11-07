<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
</head>
<body style="background: #212529">

<nav class="navbar sticky-top navbar-expand-lg navbar-dark bg-dark" style="font-size: 20px;">
    <a class="navbar-brand ml-2" href="#">Navbar</a>

    <div class="collapse navbar-collapse" id="navbarNavDropdown">
        <ul class="navbar-nav">
            <li class="nav-item">
                <a class="nav-link" href="/view/?page=0&size=3">View page</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/students/">Student page</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/examinerPage/">Examiner page</a>
            </li>
        </ul>
    </div>
</nav>

<div>
    <table class="table table-hover table-dark" style="text-align: center">
        <thead>
        <tr style="font-size: 18px;">
            <th>Specialty Name</th>
            <th>Subject 1</th>
            <th>Subject 2</th>
            <th>Subject 3</th>
        </tr>
        </thead>

        <#list specialties as s>
            <tr>
                <td>${s.name}</td>
                <td>${s.subject1.name}</td>
                <td>${s.subject2.name}</td>
                <td>${s.subject3.name}</td>
            </tr>
        </#list>
    </table>

    <#--        <a href="/students">Create student</a>-->
    <#--        <a href="/students/view">View page</a>-->
    <#--        <a href="/students/examinerView">Examiner page</a>-->

</div>
</body>
</html>