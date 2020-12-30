function loadData(){
    console.log("hello")
    var http = new XMLHttpRequest()
    var url = "https://5fe223897a948700176821b2.mockapi.io/Users";
     
    http.onreadystatechange=function(){
        if(http.readyState===4 && http.status===200){
            alert(http.responseText)
        }
    }
    http.open('GET',url)
    http.send()
}