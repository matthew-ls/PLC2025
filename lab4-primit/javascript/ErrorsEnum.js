const prompt=require("prompt-sync")({sigint:true}); 

const Error_enumobj = {
	FP_ROUNDING: "FP_ROUNDING",
	FP_OVERFLOW: "FP_OVERFLOW",
	FP_UNDERFLOW: "FP_UNDERFLOW",
	INT_OVERFLOW: "INT_OVERFLOW"
}

const Result_enumobj = {
    A_BIT_DIFFERENT: "A_BIT_DIFFERENT", 
    INFINITY: "INFINITY", 
    ZERO: "ZERO", 
    VERY_DIFFERENT: "VERY_DIFFERENT"
}

function error2Result(err){
    switch (err) {
	case Error_enumobj.FP_ROUNDING:
	 return Result_enumobj.A_BIT_DIFFERENT;
	break;
	case Error_enumobj.FP_OVERFLOW:
	    return Result_enumobj.INFINITY;
	break;
	case Error_enumobj.FP_UNDERFLOW:
	    return Result_enumobj.ZERO;
	break;
	case Error_enumobj.INT_OVERFLOW:
	    return Result_enumobj.VERY_DIFFERENT;
	break;
	default:
		return 'Invalid Error value';
}

}

console.log('Error list: ', Object.values(Error_enumobj)); //convert symbol to string
var validArg = false;
while(!validArg){
    var input = prompt("Input: ");
    let result = error2Result(input);
    if (Object.values(Result_enumobj).includes(result)){
        validArg = true;
		console.log(input + " results in " + error2Result(input)); //convert symbol to string
    }
    else{
        console.log(result);
    }
}



function result2Error(result) {
    switch (result) {
	case Result_enumobj.A_BIT_DIFFERENT:
		return Error_enumobj.FP_ROUNDING;
	case Result_enumobj.INFINITY:
		return Error_enumobj.FP_OVERFLOW;
	break;
	case Result_enumobj.ZERO:
		return Error_enumobj.FP_UNDERFLOW;
	break;
	case Result_enumobj.VERY_DIFFERENT:
		return Error_enumobj.INT_OVERFLOW;
	break;
	default:
		return 'Invalid result value';
	}
}

console.log('Result list: ', Object.values(Result_enumobj));
let err = result2Error(input);
if (Object.values(Error_enumobj).includes(err)) {
	console.log(input + " results from " + result2Error(input));
	console.log(err);
}