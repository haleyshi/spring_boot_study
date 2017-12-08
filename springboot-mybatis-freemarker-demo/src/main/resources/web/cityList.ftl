<!DOCTYPE html>

<html lang="en">

<body>
<#list cityList as city>

<p>
City: ${city.cityName}! <br>
Q:Why I like? <br>
A:${city.description}!
</p>

</#list>
</body>

</html>