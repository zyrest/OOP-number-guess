(
    function (global,factory) {
        if (global.define){
            global.define(factory);
        }else {
            global.utils = global.utils || {};
            global.utils.API = factory();
        }
    }(window, function (require) {
        let HOST = "";
        let HTTP_ADDRESS = "http://" + HOST;

        return {
            login: match(HTTP_ADDRESS + "/user/submit_login"),

        };
        // curry参数模板替换
        function match(s) {
            let reg = /{[^}]+}/;

            function __match() {
                let args = [].slice.call(arguments);

                let __s = s;
                for (let arg in args) {
                    __s = __s.replace(reg, args[arg]);
                }

                function _match() {

                    let _s = __s;

                    for (let arg in arguments) {
                        _s = _s.replace(reg, arguments[arg]);
                    }

                    if (reg.test(_s)) {
                        return __match.apply(null,args.concat([].slice.call(arguments)));
                    } else {
                        return _s;
                    }
                }

                _match.valueOf = function () {
                    return __s;
                };

                return _match;

            }

            return __match.apply(null, Array.prototype.slice.call(arguments, 1));
        }
    })
);