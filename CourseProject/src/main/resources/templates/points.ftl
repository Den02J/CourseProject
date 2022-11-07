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
    <a class="navbar-brand mr-2" href="/examinerPage/estimate/${student.id}">Estimate</a>
</nav>

<div>
    <table class="table table-hover table-dark" style="text-align: center">
        <thead>
            <td>Subject</td>
            <td>Examiner</td>
            <td>Points</td>
        </thead>

        <tr>
            <td>${student.specialty.subject1.name}</td>
            <td>${student.specialty.subject1.examiner.fullName}</td>
            <td>${student.specialty.subject1.points}</td>
        </tr>

        <tr>
            <td>${student.specialty.subject2.name}</td>
            <td>${student.specialty.subject2.examiner.fullName}</td>
            <td>${student.specialty.subject2.points}</td>
        </tr>

        <tr>
            <td>${student.specialty.subject3.name}</td>
            <td>${student.specialty.subject3.examiner.fullName}</td>
            <td>${student.specialty.subject3.points}</td>
        </tr>
    </table>

</div>
</body>
</html>