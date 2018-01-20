# polishNotation

Convert strings of an infix equation to a string in prefix or [Polish Notation](https://en.wikipedia.org/wiki/Polish_notation).

Current output:
```
******************************
Infix Value : 3*(1+2)
Expected Prefix Value: *,3,+,1,2
Current Prefix Output: *,3,+,1,2,
******************************
Infix Value : (3+5)*2
Expected Prefix Value: *,+,3,5,2
Current Prefix Output: *,+,3,5,2
******************************
Infix Value : (8+2)*(3+4)
Expected Prefix Value: *,+,8,2,+,3,4
Current Prefix Output: *,+,8,2,+,3,4,
******************************
Infix Value : 4/(1+1)
Expected Prefix Value: /,4,+,1,1
Current Prefix Output: /,4,+,1,1,
******************************
Infix Value : (3+1)/2
Expected Prefix Value: /,+,3,1,2
Current Prefix Output: /,+,3,1,2
******************************
Infix Value : 3+1*2
Expected Prefix Value: +,3,*,1,2
Current Prefix Output: +,3,*,1,2,
******************************
Infix Value : 3*1+2
Expected Prefix Value: +,*,3,1,2
Current Prefix Output: +,*,3,1,2
******************************
Infix Value : 88+5
Expected Prefix Value: +,88,5
Current Prefix Output: +,88,5
```
