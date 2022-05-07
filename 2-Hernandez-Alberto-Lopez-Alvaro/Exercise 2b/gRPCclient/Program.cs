using Grpc.Net.Client;
using System;
using System.Threading.Tasks;

namespace gRPCclient
{
    class Program
    {
        static async Task Main(string[] args)
        {
            MyData.info();
            Console.WriteLine("Starting gRPC Client");
            using var channel = GrpcChannel.ForAddress("https://localhost:5001");
            var client = new GrpcService.GrpcServiceClient(channel);
            Console.Write("Enter the name: ");
            String str = Console.ReadLine();
            Console.Write("Enter age: ");
            int val = int.Parse(Console.ReadLine());
            var reply = await client.GrpcProcAsync(new GrpcRequest
            {
                Name = str,
                Age = val
            });
            Console.WriteLine("From server: " + reply.Message);
            Console.WriteLine("From server: " + val + " years = " + reply.Days + " days");
            Console.WriteLine("Press any key to exit...");
            Console.ReadKey();
            channel.ShutdownAsync().Wait();
        }
    }
}
