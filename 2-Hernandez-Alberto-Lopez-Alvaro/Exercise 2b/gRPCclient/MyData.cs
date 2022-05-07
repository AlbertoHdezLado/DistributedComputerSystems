// Include namespace system
using System;
using System.Net;

public class MyData
{
    public static void info()
    {
        var dt = DateTime.Now.ToString("yyyy/MM/dd");
        Console.WriteLine("yyyy/MM/dd " + dt);
        Console.WriteLine("Data:Alvaro Lopez Pereda and Alberto Hernandez Lado");
        Console.WriteLine("UserName: {0}", Environment.UserName);
        Console.WriteLine("Operating System Name:" + Environment.MachineName);
        String strHostName = string.Empty;
        IPHostEntry ipEntry = Dns.GetHostEntry(Dns.GetHostName());
        IPAddress[] addr = ipEntry.AddressList;

        for (int i = 0; i < addr.Length; i++)
        {
            Console.WriteLine("IP Address {0}: {1} ", i, addr[i].ToString());
        }
    }
}