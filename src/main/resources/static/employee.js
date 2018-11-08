function getDepartment(){
    var HttpObject = new XMLHttpRequest();
    var url = "http://localhost:8080/json";
    HttpObject.open('GET', url);
    HttpObject.setRequestHeader("Content-Type", "application/json");
    HttpObject.responseType= 'json';
    HttpObject.send();

    HttpObject.onreadystatechange = function (){
        if(this.readyState ==1){
            console.log("Connection established");
        }

        if(this.readyState==3)
        {
            console.log("Loading Data");
        }
        if(this.readyState==4)
        {
            console.log("Done");
            if(this.status==200)
            {
                console.log("Result successful. Check your page.");
                theResponse = this.response;
                // showDepartment(theResponse);
                console.log(theResponse);
            }
            else{
                console.log("Something went wrong. Check below for details");
                console.log(this.statusText);
            }
        }
    }
}

/*
function adddepartment(){
    var obj = new XMLHttpRequest();
    obj.open("POST", "http://localhost:8080/adddepartment")
    obj.setRequestHeader("Content-Type", "application/json");
    var department = JSON.stringify({"name": })
}
*/

/*
function showDepartment(){
    var display(result);
    for(i=0; i<result.)

}*/
