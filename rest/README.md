## /employees
Working request for `POST /employees`:
```$xslt
{
  "name": "Marc",
  "role": {
    "rolename": "Developer",
    "rating": 5
  }
}
```

Broken request for `POST /employees`:
```$xslt
{
  "name": "Marc",
  "role": {
    "rolename": "",
    "rating": -1
  }
}
```

## /employees/bulk
Working request for `POST /employees/bulk`, which should be broken!
```$xslt
{
  "brokenRequest": {
    "name": "Marc",
    "role": {
      "rolename": "",
      "rating": -1
    }
  }
}
```

```