function outer(){
    let name="abhi";
    function inner(){
        console.log("hello "+name);
    }
    return inner;
}
