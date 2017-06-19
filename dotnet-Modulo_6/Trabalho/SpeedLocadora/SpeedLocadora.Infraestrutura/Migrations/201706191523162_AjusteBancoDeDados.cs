namespace SpeedLocadora.Infraestrutura.Migrations
{
    using System;
    using System.Data.Entity.Migrations;
    
    public partial class AjusteBancoDeDados : DbMigration
    {
        public override void Up()
        {
            DropForeignKey("dbo.LocacaoAcessorios", "Acessorio_IdAcessorio", "dbo.Acessorios");
            DropForeignKey("dbo.LocacaoAcessorios", "Locacao_IdLocacao", "dbo.Locacao");
            DropForeignKey("dbo.PacoteAcessorios", "Acessorio_IdAcessorio", "dbo.Acessorios");
            DropForeignKey("dbo.PacoteAcessorios", "Pacote_IdPacote", "dbo.Pacotes");
            DropForeignKey("dbo.Locacao", "IdPacoteAcessorio", "dbo.PacoteAcessorios");
            DropForeignKey("dbo.Locacao", "IdUsuario", "dbo.Usuarios");
            DropForeignKey("dbo.PermissaoUsuario", "IdUsuario", "dbo.Usuarios");
            DropIndex("dbo.LocacaoAcessorios", new[] { "Acessorio_IdAcessorio" });
            DropIndex("dbo.LocacaoAcessorios", new[] { "Locacao_IdLocacao" });
            DropIndex("dbo.Locacao", new[] { "IdPacoteAcessorio" });
            DropIndex("dbo.Locacao", new[] { "IdUsuario" });
            DropIndex("dbo.PacoteAcessorios", new[] { "Acessorio_IdAcessorio" });
            DropIndex("dbo.PacoteAcessorios", new[] { "Pacote_IdPacote" });
            DropPrimaryKey("dbo.Usuarios");
            CreateTable(
                "dbo.LocacaoAcessorio",
                c => new
                    {
                        IdLocacao = c.Int(nullable: false),
                        IdAcessorio = c.Int(nullable: false),
                    })
                .PrimaryKey(t => new { t.IdLocacao, t.IdAcessorio })
                .ForeignKey("dbo.Locacao", t => t.IdLocacao, cascadeDelete: true)
                .ForeignKey("dbo.Acessorios", t => t.IdAcessorio, cascadeDelete: true)
                .Index(t => t.IdLocacao)
                .Index(t => t.IdAcessorio);
            
            CreateTable(
                "dbo.PacoteAcessorio",
                c => new
                    {
                        IdPacote = c.Int(nullable: false),
                        IdAcessorio = c.Int(nullable: false),
                    })
                .PrimaryKey(t => new { t.IdPacote, t.IdAcessorio })
                .ForeignKey("dbo.Pacotes", t => t.IdPacote, cascadeDelete: true)
                .ForeignKey("dbo.Acessorios", t => t.IdAcessorio, cascadeDelete: true)
                .Index(t => t.IdPacote)
                .Index(t => t.IdAcessorio);
            
            AddColumn("dbo.Locacao", "IdPacote", c => c.Int());
            AddColumn("dbo.Usuarios", "Id", c => c.Int(nullable: false, identity: true));
            AlterColumn("dbo.Pacotes", "Tipo", c => c.String(maxLength: 300));
            AddPrimaryKey("dbo.Usuarios", "Id");
            CreateIndex("dbo.Locacao", "IdPacote");
            AddForeignKey("dbo.Locacao", "IdPacote", "dbo.Pacotes", "IdPacote");
            AddForeignKey("dbo.PermissaoUsuario", "IdUsuario", "dbo.Usuarios", "Id", cascadeDelete: true);
            DropColumn("dbo.Locacao", "IdPacoteAcessorio");
            DropColumn("dbo.Locacao", "IdUsuario");
            DropColumn("dbo.Usuarios", "IdUsuario");
            DropColumn("dbo.Usuarios", "NomeUsuario");
            DropTable("dbo.LocacaoAcessorios");
            DropTable("dbo.PacoteAcessorios");
        }
        
        public override void Down()
        {
            CreateTable(
                "dbo.PacoteAcessorios",
                c => new
                    {
                        Id = c.Int(nullable: false, identity: true),
                        Quantidade = c.Int(nullable: false),
                        Acessorio_IdAcessorio = c.Int(),
                        Pacote_IdPacote = c.Int(),
                    })
                .PrimaryKey(t => t.Id);
            
            CreateTable(
                "dbo.LocacaoAcessorios",
                c => new
                    {
                        Id = c.Int(nullable: false, identity: true),
                        Quantidade = c.Int(nullable: false),
                        Acessorio_IdAcessorio = c.Int(),
                        Locacao_IdLocacao = c.Int(),
                    })
                .PrimaryKey(t => t.Id);
            
            AddColumn("dbo.Usuarios", "NomeUsuario", c => c.String());
            AddColumn("dbo.Usuarios", "IdUsuario", c => c.Int(nullable: false, identity: true));
            AddColumn("dbo.Locacao", "IdUsuario", c => c.Int(nullable: false));
            AddColumn("dbo.Locacao", "IdPacoteAcessorio", c => c.Int());
            DropForeignKey("dbo.PermissaoUsuario", "IdUsuario", "dbo.Usuarios");
            DropForeignKey("dbo.Locacao", "IdPacote", "dbo.Pacotes");
            DropForeignKey("dbo.PacoteAcessorio", "IdAcessorio", "dbo.Acessorios");
            DropForeignKey("dbo.PacoteAcessorio", "IdPacote", "dbo.Pacotes");
            DropForeignKey("dbo.LocacaoAcessorio", "IdAcessorio", "dbo.Acessorios");
            DropForeignKey("dbo.LocacaoAcessorio", "IdLocacao", "dbo.Locacao");
            DropIndex("dbo.PacoteAcessorio", new[] { "IdAcessorio" });
            DropIndex("dbo.PacoteAcessorio", new[] { "IdPacote" });
            DropIndex("dbo.LocacaoAcessorio", new[] { "IdAcessorio" });
            DropIndex("dbo.LocacaoAcessorio", new[] { "IdLocacao" });
            DropIndex("dbo.Locacao", new[] { "IdPacote" });
            DropPrimaryKey("dbo.Usuarios");
            AlterColumn("dbo.Pacotes", "Tipo", c => c.String());
            DropColumn("dbo.Usuarios", "Id");
            DropColumn("dbo.Locacao", "IdPacote");
            DropTable("dbo.PacoteAcessorio");
            DropTable("dbo.LocacaoAcessorio");
            AddPrimaryKey("dbo.Usuarios", "IdUsuario");
            CreateIndex("dbo.PacoteAcessorios", "Pacote_IdPacote");
            CreateIndex("dbo.PacoteAcessorios", "Acessorio_IdAcessorio");
            CreateIndex("dbo.Locacao", "IdUsuario");
            CreateIndex("dbo.Locacao", "IdPacoteAcessorio");
            CreateIndex("dbo.LocacaoAcessorios", "Locacao_IdLocacao");
            CreateIndex("dbo.LocacaoAcessorios", "Acessorio_IdAcessorio");
            AddForeignKey("dbo.PermissaoUsuario", "IdUsuario", "dbo.Usuarios", "IdUsuario", cascadeDelete: true);
            AddForeignKey("dbo.Locacao", "IdUsuario", "dbo.Usuarios", "IdUsuario", cascadeDelete: true);
            AddForeignKey("dbo.Locacao", "IdPacoteAcessorio", "dbo.PacoteAcessorios", "Id");
            AddForeignKey("dbo.PacoteAcessorios", "Pacote_IdPacote", "dbo.Pacotes", "IdPacote");
            AddForeignKey("dbo.PacoteAcessorios", "Acessorio_IdAcessorio", "dbo.Acessorios", "IdAcessorio");
            AddForeignKey("dbo.LocacaoAcessorios", "Locacao_IdLocacao", "dbo.Locacao", "IdLocacao");
            AddForeignKey("dbo.LocacaoAcessorios", "Acessorio_IdAcessorio", "dbo.Acessorios", "IdAcessorio");
        }
    }
}
