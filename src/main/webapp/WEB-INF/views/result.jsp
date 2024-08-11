<!DOCTYPE html>
<html>
<script>
<%
    String clock = request.getParameter( "time" );
    if( clock == null ) clock = "10";
%>
var timeout = <%=clock%>;
function timer()
    {
        if( --timeout > 0 )
        {
            document.txt.clock.value = timeout;
            window.setTimeout( "timer()", 1000 );
        }
        else
        {
            document.txt.clock.value = 0;
        }
    }
</script>
<body>
    <form action="<%=request.getRequestURL()%>" name="txt">
        <label>Time:
            <input type="text" name="clock" value="<%=clock%>">
        </label>
    </form>
<script>
    timer();
</script>
</body>
</html>