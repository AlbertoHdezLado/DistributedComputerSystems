using Grpc.Core;
using Microsoft.Extensions.Logging;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace gRPCclient
{
    public class MyGrpcService : GrpcService.GrpcServiceBase
    {
        private readonly ILogger<MyGrpcService> _logger;
        public MyGrpcService(ILogger<MyGrpcService> logger)
        {
            _logger = logger;
        }

        public override Task<GrpcResponse> GrpcProc(GrpcRequest request, ServerCallContext context)
        {
            string msg;
            int val;
            val = request.Age * 12 * 365;
            msg = "Hello " + request.Name + " being " + request.Age + " years old.";
            return Task.FromResult(new GrpcResponse { Message = msg, Days = val });
        }
    } 
}
