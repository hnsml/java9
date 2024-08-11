<!DOCTYPE html>
<html>
<body>
<form action="task3_res" method="post">
    <label>
        <input type="radio" name="option" value="education"/> Education
    </label><br/>
    <label>
        <input type="radio" name="option" value="relationship"/> Relationship
    </label><br/>
    <label>
        <input type="radio" name="option" value="history"/> History
    </label><br/>
    <label>
        <input type="radio" name="option" value="individual_growth"/> Individual growth
    </label><br/>
    <button type="submit">Submit</button>
</form>
<p>${quote}</p>
<form action="task3_search_res" method="post">
    <label>
        <input type="search" name="search">
    </label><br/>
    <input type="submit">
</form>
<p>${search_res}</p>
</body>
</html>