namespace SpeedLocadora.Infraestrutura.Migrations
{
    using System;
    using System.Data.Entity.Migrations;
    
    public partial class CriacaoDoBanco : DbMigration
    {
        public override void Up()
        {
            CreateTable(
                "dbo.Acessorios",
                c => new
                    {
                        IdAcessorio = c.Int(nullable: false, identity: true),
                        NomeAcessorio = c.String(),
                        Quantidade = c.Int(nullable: false),
                    })
                .PrimaryKey(t => t.IdAcessorio);
            
            CreateTable(
                "dbo.LocacaoAcessorios",
                c => new
                    {
                        Id = c.Int(nullable: false, identity: true),
                        Quantidade = c.Int(nullable: false),
                        Acessorio_IdAcessorio = c.Int(),
                        Locacao_IdLocacao = c.Int(),
                    })
                .PrimaryKey(t => t.Id)
                .ForeignKey("dbo.Acessorios", t => t.Acessorio_IdAcessorio)
                .ForeignKey("dbo.Locacao", t => t.Locacao_IdLocacao)
                .Index(t => t.Acessorio_IdAcessorio)
                .Index(t => t.Locacao_IdLocacao);
            
            CreateTable(
                "dbo.Locacao",
                c => new
                    {
                        IdLocacao = c.Int(nullable: false, identity: true),
                        DataLocacao = c.DateTime(nullable: false),
                        DataEntrega = c.DateTime(nullable: false),
                        PrevisaoEntrega = c.DateTime(nullable: false),
                        PrecoFinal = c.Double(nullable: false),
                        PrecoPrevisto = c.Double(nullable: false),
                        IdCliente = c.Int(nullable: false),
                        IdPacoteAcessorio = c.Int(),
                        IdUsuario = c.Int(nullable: false),
                        IdVideoGame = c.Int(nullable: false),
                    })
                .PrimaryKey(t => t.IdLocacao)
                .ForeignKey("dbo.Clientes", t => t.IdCliente, cascadeDelete: true)
                .ForeignKey("dbo.PacoteAcessorios", t => t.IdPacoteAcessorio)
                .ForeignKey("dbo.Usuarios", t => t.IdUsuario, cascadeDelete: true)
                .ForeignKey("dbo.VideoGame", t => t.IdVideoGame, cascadeDelete: true)
                .Index(t => t.IdCliente)
                .Index(t => t.IdPacoteAcessorio)
                .Index(t => t.IdUsuario)
                .Index(t => t.IdVideoGame);
            
            CreateTable(
                "dbo.Clientes",
                c => new
                    {
                        IdCliente = c.Int(nullable: false, identity: true),
                        NomeClie = c.String(),
                        Endereco = c.String(),
                        CPF = c.String(),
                        Genero = c.String(),
                        DataNascimento = c.DateTime(nullable: false),
                    })
                .PrimaryKey(t => t.IdCliente);
            
            CreateTable(
                "dbo.PacoteAcessorios",
                c => new
                    {
                        Id = c.Int(nullable: false, identity: true),
                        Quantidade = c.Int(nullable: false),
                        Acessorio_IdAcessorio = c.Int(),
                        Pacote_IdPacote = c.Int(),
                    })
                .PrimaryKey(t => t.Id)
                .ForeignKey("dbo.Acessorios", t => t.Acessorio_IdAcessorio)
                .ForeignKey("dbo.Pacotes", t => t.Pacote_IdPacote)
                .Index(t => t.Acessorio_IdAcessorio)
                .Index(t => t.Pacote_IdPacote);
            
            CreateTable(
                "dbo.Pacotes",
                c => new
                    {
                        IdPacote = c.Int(nullable: false, identity: true),
                        Tipo = c.String(),
                        Valor = c.Double(nullable: false),
                        VideoGame_IdVideoGame = c.Int(),
                    })
                .PrimaryKey(t => t.IdPacote)
                .ForeignKey("dbo.VideoGame", t => t.VideoGame_IdVideoGame)
                .Index(t => t.VideoGame_IdVideoGame);
            
            CreateTable(
                "dbo.VideoGame",
                c => new
                    {
                        IdVideoGame = c.Int(nullable: false, identity: true),
                        NomeVideoGame = c.String(),
                        Quantidade = c.Int(nullable: false),
                        Valor = c.Double(nullable: false),
                    })
                .PrimaryKey(t => t.IdVideoGame);
            
            CreateTable(
                "dbo.Usuarios",
                c => new
                    {
                        IdUsuario = c.Int(nullable: false, identity: true),
                        NomeUsuario = c.String(),
                        Email = c.String(),
                        Senha = c.String(),
                    })
                .PrimaryKey(t => t.IdUsuario);
            
            CreateTable(
                "dbo.Permissao",
                c => new
                    {
                        Id = c.Int(nullable: false, identity: true),
                        Nome = c.String(),
                    })
                .PrimaryKey(t => t.Id);
            
            CreateTable(
                "dbo.PermissaoUsuario",
                c => new
                    {
                        IdUsuario = c.Int(nullable: false),
                        IdPermissao = c.Int(nullable: false),
                    })
                .PrimaryKey(t => new { t.IdUsuario, t.IdPermissao })
                .ForeignKey("dbo.Usuarios", t => t.IdUsuario, cascadeDelete: true)
                .ForeignKey("dbo.Permissao", t => t.IdPermissao, cascadeDelete: true)
                .Index(t => t.IdUsuario)
                .Index(t => t.IdPermissao);
            
        }
        
        public override void Down()
        {
            DropForeignKey("dbo.Locacao", "IdVideoGame", "dbo.VideoGame");
            DropForeignKey("dbo.Locacao", "IdUsuario", "dbo.Usuarios");
            DropForeignKey("dbo.PermissaoUsuario", "IdPermissao", "dbo.Permissao");
            DropForeignKey("dbo.PermissaoUsuario", "IdUsuario", "dbo.Usuarios");
            DropForeignKey("dbo.Locacao", "IdPacoteAcessorio", "dbo.PacoteAcessorios");
            DropForeignKey("dbo.Pacotes", "VideoGame_IdVideoGame", "dbo.VideoGame");
            DropForeignKey("dbo.PacoteAcessorios", "Pacote_IdPacote", "dbo.Pacotes");
            DropForeignKey("dbo.PacoteAcessorios", "Acessorio_IdAcessorio", "dbo.Acessorios");
            DropForeignKey("dbo.Locacao", "IdCliente", "dbo.Clientes");
            DropForeignKey("dbo.LocacaoAcessorios", "Locacao_IdLocacao", "dbo.Locacao");
            DropForeignKey("dbo.LocacaoAcessorios", "Acessorio_IdAcessorio", "dbo.Acessorios");
            DropIndex("dbo.PermissaoUsuario", new[] { "IdPermissao" });
            DropIndex("dbo.PermissaoUsuario", new[] { "IdUsuario" });
            DropIndex("dbo.Pacotes", new[] { "VideoGame_IdVideoGame" });
            DropIndex("dbo.PacoteAcessorios", new[] { "Pacote_IdPacote" });
            DropIndex("dbo.PacoteAcessorios", new[] { "Acessorio_IdAcessorio" });
            DropIndex("dbo.Locacao", new[] { "IdVideoGame" });
            DropIndex("dbo.Locacao", new[] { "IdUsuario" });
            DropIndex("dbo.Locacao", new[] { "IdPacoteAcessorio" });
            DropIndex("dbo.Locacao", new[] { "IdCliente" });
            DropIndex("dbo.LocacaoAcessorios", new[] { "Locacao_IdLocacao" });
            DropIndex("dbo.LocacaoAcessorios", new[] { "Acessorio_IdAcessorio" });
            DropTable("dbo.PermissaoUsuario");
            DropTable("dbo.Permissao");
            DropTable("dbo.Usuarios");
            DropTable("dbo.VideoGame");
            DropTable("dbo.Pacotes");
            DropTable("dbo.PacoteAcessorios");
            DropTable("dbo.Clientes");
            DropTable("dbo.Locacao");
            DropTable("dbo.LocacaoAcessorios");
            DropTable("dbo.Acessorios");
        }
    }
}
