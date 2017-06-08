namespace SpeedLocadora.Infraestrutura.Migrations
{
    using System;
    using System.Data.Entity.Migrations;
    
    public partial class TesteDeMigration : DbMigration
    {
        public override void Up()
        {
            DropForeignKey("dbo.Pacotes", "VideoGame_IdVideoGame", "dbo.VideoGame");
            DropIndex("dbo.Pacotes", new[] { "VideoGame_IdVideoGame" });
            AddColumn("dbo.Acessorios", "Valor", c => c.Double(nullable: false));
            AddColumn("dbo.Pacotes", "DiasDeDuracao", c => c.Int(nullable: false));
            DropColumn("dbo.Pacotes", "VideoGame_IdVideoGame");
        }
        
        public override void Down()
        {
            AddColumn("dbo.Pacotes", "VideoGame_IdVideoGame", c => c.Int());
            DropColumn("dbo.Pacotes", "DiasDeDuracao");
            DropColumn("dbo.Acessorios", "Valor");
            CreateIndex("dbo.Pacotes", "VideoGame_IdVideoGame");
            AddForeignKey("dbo.Pacotes", "VideoGame_IdVideoGame", "dbo.VideoGame", "IdVideoGame");
        }
    }
}
