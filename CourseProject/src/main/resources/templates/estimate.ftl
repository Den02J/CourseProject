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

<div style="width: 180px; margin: auto; color: white; font-size: 16px;">
    <fieldset>
        <legend style="text-align: center">Estimate ${student.firstName} ${student.lastName}</legend>
        <form style="text-align: center" name="student" action="" method="POST">
            Examiner
            <select name="examiner1">
                <#list examiners as e>
                    <#if e.subject == student.specialty.subject1.name>
                        <option name="examiner1">${e.fullName}</option>
                    </#if>
                </#list>
            </select>
            <br>
            Points for ${student.specialty.subject1.name} <br>
            <@spring.formInput "form.points1" "" "text"/>
            <br>

            Examiner
            <select name="examiner2">
                <#list examiners as e>
                    <#if e.subject == student.specialty.subject2.name>
                        <option name="examiner2">${e.fullName}</option>
                    </#if>
                </#list>
            </select>
            <br>
            Points for ${student.specialty.subject2.name} <br>
            <@spring.formInput "form.points2" "" "text"/>
            <br>

            Examiner
            <select name="examiner3">
                <#list examiners as e>
                    <#if e.subject == student.specialty.subject3.name>
                        <option name="examiner3">${e.fullName}</option>
                    </#if>
                </#list>
            </select>
            <br>
            Points for ${student.specialty.subject3.name}
            <@spring.formInput "form.points3" "" "text"/>
            <br>
            <br>

            <div style="text-align: center">
                <input class="btn btn-light" type=submit value="Submit">
            </div>
        </form>
    </fieldset>
</div>
</body>
</html>