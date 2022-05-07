using Grpc.Core;
using Mygrpcproto;
using System;
using System.Threading.Tasks;

namespace gRPCserver{
    class MyGrpcSrvImpl : MyGrpcSrv.MyGrpcSrvBase {
        public override Task<AddIntReply> addInt(AddIntRequest req, ServerCallContext ctx) {
            string comment;
            int result = req.Num1 + req.Num2;
            if (result >= 0){
                comment = "+";
            }
            else if (result < 0){
                comment = "-";
            }
            else{
                comment = " ";
            }
            
            return Task.FromResult(new AddIntReply { Result = result, Comment = comment });
        } 
    }
    class Program {
        const int port = 10000;
        static void Main(string[] args)
        {
            Console.WriteLine("Starting Hello gRPC server");
            Server myServer = new Server()
            { //now we define the services and ports of our server.
                Services = { MyGrpcSrv.BindService(new MyGrpcSrvImpl()) },   //The service we start is to generate this class, with all the methods.
                Ports = { new ServerPort("localhost", port, ServerCredentials.Insecure) } //define the port we will work on.
            };
            myServer.Start(); //the server starts
            Console.WriteLine("Hello gRPC server listening on port " + port);
            Console.WriteLine("Press any key to stop the server...");
            Console.ReadKey();  //After we press any key, the program continues
            myServer.ShutdownAsync().Wait(); //The server ends asyncronously, waiting for last process.
        }
    }

}
